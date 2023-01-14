package net.serveron.hane.commandregister.command;

import net.serveron.hane.commandregister.CommandRegister;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import net.serveron.hane.commandregister.util.PlayerSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TemplateCommand implements CommandExecutor, TabCompleter {
    private final CommandRegister plugin;
    public TemplateCommand(CommandRegister plugin){
        this.plugin = plugin;
        plugin.getCommand("example").setExecutor(this);
    }

    // コマンドの仕様
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof BlockCommandSender)){
            sender.sendMessage("このコマンドはコマンドブロック専用です。");
            return true;
        }
        // コマンドブロック
        BlockCommandSender cb = (BlockCommandSender) sender;
        // コマンドブロックを押した最も近いプレイヤー
        Player player = PlayerSearch.getNearbyPlayer(cb.getBlock().getLocation());

        // プレイヤーがいるか確認
        if(player!=null){
            if(args.length == 1) {
                // do something
            }
        }
        return true;
    }

    //　タブ補完
    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String command, String[] args) {
        List<String> autoComplete = new ArrayList<>();
        if(sender.hasPermission("example")){
            if (args.length == 1){//一段目
                autoComplete.addAll(Arrays.asList("test","test","test"));
            }
            /*
            else if(args.length == 2){//二段目
                if(args[0].equals("remove")){

                }
            }*/
        }

        //文字比較と削除
        //Collections.sort(autoComplete);
        autoComplete.removeIf(str -> !str.startsWith(args[args.length - 1]));
        return autoComplete;
    }
}
