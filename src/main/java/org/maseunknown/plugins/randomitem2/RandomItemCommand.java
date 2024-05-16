package org.maseunknown.plugins.randomitem2;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.*;

public class RandomItemCommand implements CommandExecutor {
    private static RandomItem2 randomItem;
    private static BukkitTask task;
    public RandomItemCommand(RandomItem2 randomizer) { RandomItemCommand.randomItem = randomizer; }

    ArrayList<Material> materials = new ArrayList<Material>();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }
        Player p = (Player) sender;
        if (args.length == 0) {
            p.sendMessage(ChatColor.DARK_RED + "You must type an argument. For help, type: /randomizer help");
            return true;
        }
        if (args[0].equals("help")) {
            if (args.length != 1) {
                p.sendMessage(ChatColor.DARK_RED + "Wrong usage of this command. For help, type: /randomizer help");
                return true;
            } else {
                p.sendMessage(ChatColor.DARK_GREEN + "------- " + ChatColor.WHITE + " Minecraft Item Randomizer " + ChatColor.DARK_GREEN + "----------");
                p.sendMessage(ChatColor.DARK_GREEN + "Here is a list of randomizer commands:");
                p.sendMessage(ChatColor.GREEN + "/randomizer start  ... " + ChatColor.WHITE + "- starts the randomizer");
                p.sendMessage(ChatColor.GREEN + "/randomizer stop <player> <player> ... " + ChatColor.WHITE + "- stops the randomizer");
                p.sendMessage(ChatColor.GREEN + "/randomizer help " + ChatColor.WHITE + "- displays randomizer help menu");
            }
        }

        if (args[0].equals("start") || args[0].equals("stop")) {
            if (args.length != 1) {
                p.sendMessage(ChatColor.DARK_RED + "Wrong use of this command. For help, type: /randomizer help");
            } else {
                if (args[0].equals("stop")) {
                    Bukkit.getScheduler().cancelTask(RandomItemCommand.task.getTaskId());
                    p.sendMessage(ChatColor.DARK_RED + "RANDOMIZER STOPPED");
                } else {
                    MaterialManager();
                    task = (new BukkitRunnable() {
                        public void run() {
                            int inv = p.getInventory().firstEmpty();
                            ItemStack randomItem = getRandomMaterial();
                            if (inv != -1) {
                                p.getInventory().setItem(inv, randomItem);
                                p.sendMessage(ChatColor.GREEN + "NEW ITEM GENERATED");
                            } else {
                                p.getWorld().dropItem(p.getLocation(), randomItem);
                                p.sendMessage(ChatColor.GREEN + "INVENTORY FULL, NEW ITEM GENERATED ON GROUND");
                            }
                        }
                    }).runTaskTimer(randomItem, 1200L, 1200L);
                }
            }
        }
        return true;
    }
    public void MaterialManager() {
        System.out.println("Loading materials...");
        for (Material material : Material.values())
        {
            if (material != null && !material.isAir()) {
                if (!material.name().toLowerCase().contains("template") && !material.name().toLowerCase().contains("sherd") && !material.name().toLowerCase().contains("potted") && !material.name().toLowerCase().contains("vines_plant") && !material.name().toLowerCase().contains("wall_fan") && !material.name().toLowerCase().contains("barrier") && !material.name().toLowerCase().contains("command_block") && !material.name().toLowerCase().contains("void")) {
                    System.out.println(material.name());
                    materials.add(material);
                }
            }
        }
        materials.add(Material.LAVA_BUCKET);
        materials.add(Material.OBSIDIAN);
        materials.add(Material.WATER_BUCKET);
        materials.add(Material.OBSIDIAN);
    }

    public ItemStack getRandomMaterial() {
        Material newMat = materials.get(new Random().nextInt(materials.size()));
        System.out.println("Generating item..." + newMat.toString());
        return new ItemStack(newMat);
    }
}
