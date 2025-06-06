package main.java.managers;

import commands.ExecutableCommand;
import commands.Command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class CommandManager {
    private static CommandManager commandManager;
    private static final HashMap<String, ExecutableCommand> executableCommands = new HashMap<>();
    private static final HashMap<String, ExecutableCommand> serverCommands = new HashMap<>();
    private static final HashMap<String, Command> commands = new HashMap<>();
    private static final ArrayList<String> commandHistory = new ArrayList<>();

    private CommandManager() {}

    /**
     * Метод, использующийся для получения CommandManager.
     * Создаёт новый объект, если текущий объект ещё не создан.
     * @return commandManager
     */
    public static CommandManager getCommandManager() {
        if (commandManager == null) {
            commandManager = new CommandManager();
        }
        return commandManager;
    }

    /**
     * Добавляет новую команду.
     * @param executableCommand команда
     */
    public static void newCommand(ExecutableCommand executableCommand) {
        executableCommands.put(executableCommand.getName(), executableCommand);
        Command command = new Command(executableCommand.getName(), executableCommand.getDescription(),
                executableCommand.getPositionalArguments(), executableCommand.getArguments());
        commands.put(command.getName(), command);
    }

    /**
     * Добавляет новую серверную команду.
     * @param executableCommand команда
     */
    public static void newServerCommand(ExecutableCommand executableCommand) {
        serverCommands.put(executableCommand.getName(), executableCommand);
    }

    /**
     * Добавляет команду в историю.
     */
    public static void addToHistory(String command) {
        commandHistory.add(command);
    }

    /**
     * @return словарь с доступными командами
     */
    public static HashMap<String, Command> getCommands() {
        return commands;
    }

    /**
     * @return словарь с доступными командами
     */
    public static HashMap<String, ExecutableCommand> getExecutableCommands() {
        return executableCommands;
    }

    /**
     * @return словарь с доступными серверными командами
     */
    public static HashMap<String, ExecutableCommand> getServerCommands() {
        return serverCommands;
    }

    /**
     * @return список выполненных команд
     */
    public static ArrayList<String> getCommandHistory() {
        return commandHistory;
    }

    /**
     * @return список названий доступных команд
     */
    public static ArrayList<String> getCommandList() {
        Set<String> commandSet = commands.keySet();
        ArrayList<String> commandList = new ArrayList<>();
        for (String cmd : commandSet) {
            commandList.add(cmd);
        }
        return commandList;
    }
}
