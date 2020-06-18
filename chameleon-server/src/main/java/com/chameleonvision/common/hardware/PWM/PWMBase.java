package com.chameleonvision.common.hardware.PWM;

import com.chameleonvision.common.util.ShellExec;

import java.util.HashMap;

public abstract class PWMBase {
    HashMap<String, String> commands =
            new HashMap<>() {
                {
                    put("setRate", "");
                    put("setRange", "");
                    put("shutdown", "");
                }
            };

    private final ShellExec runCommand = new ShellExec(true, true);

    public String execute(String command){
        try {
            runCommand.executeBashCommand(command);
        }catch (Exception e){
            return "";
        }
        return runCommand.getOutput();
    }

    public void setPwmRateCommand(String command) {
        commands.replace("setRate", command);
    }

    public void setPwmRangeCommand(String command) {
        commands.replace("setRange", command);
    }

    public abstract void setPwmRate(int rate);

    public abstract void setPwmRange(int range);

    public abstract int getPwmRate();

    public abstract int getPwmRange();

    public abstract boolean shutdown();
}