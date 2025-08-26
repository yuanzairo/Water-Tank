import javax.swing.*;

abstract class WaterTank {
    int capacity;
    int currentWaterLevel;

    public WaterTank(int capacity) {
        this.capacity = capacity;
        this.currentWaterLevel = 0;
    }

    public abstract void fillTank(int liters);
    public abstract void useWater(int liters);
    public abstract void checkStatus();
}
class HomeTank extends WaterTank {

    public HomeTank() {
        super(200);
    }

    @Override
    public void fillTank(int liters) {
        if (currentWaterLevel + liters <= capacity) {
            currentWaterLevel += liters;
            JOptionPane.showMessageDialog(null, liters + " liters added. Current level: " + currentWaterLevel + "/" + capacity);
        } else {
            JOptionPane.showMessageDialog(null, "Cannot add more than the tank's capacity.");
        }
    }

    @Override
    public void useWater(int liters) {
        if (currentWaterLevel - liters >= 0) {
            currentWaterLevel -= liters;
            JOptionPane.showMessageDialog(null, liters + " liters used. Current level: " + currentWaterLevel + "/" + capacity);
        } else {
            JOptionPane.showMessageDialog(null, "Not enough water in the tank.");
        }
    }

    @Override
    public void checkStatus() {
        if (currentWaterLevel == capacity) {
            JOptionPane.showMessageDialog(null, "Tank is Full.");
        } else if (currentWaterLevel == 0) {
            JOptionPane.showMessageDialog(null, "Tank is Empty.");
        } else {
            JOptionPane.showMessageDialog(null, "Tank is In Use.");
        }
    }
}
class BuildingTank extends WaterTank {

    public BuildingTank() {
        super(1000);
    }

    @Override
    public void fillTank(int liters) {
        if (currentWaterLevel + liters <= capacity) {
            currentWaterLevel += liters;
            JOptionPane.showMessageDialog(null, liters + " liters added. Current level: " + currentWaterLevel + "/" + capacity);
        } else {
            JOptionPane.showMessageDialog(null, "Cannot add more than the tank's capacity.");
        }
    }

    @Override
    public void useWater(int liters) {
        if (currentWaterLevel - liters >= 0) {
            currentWaterLevel -= liters;
            JOptionPane.showMessageDialog(null, liters + " liters used. Current level: " + currentWaterLevel + "/" + capacity);
        } else {
            JOptionPane.showMessageDialog(null, "Not enough water in the tank.");
        }
    }

    @Override
    public void checkStatus() {
        if (currentWaterLevel == capacity) {
            JOptionPane.showMessageDialog(null, "Tank is Full.");
        } else if (currentWaterLevel == 0) {
            JOptionPane.showMessageDialog(null, "Tank is Empty.");
        } else {
            JOptionPane.showMessageDialog(null, "Tank is In Use.");
        }
    }
}
public class Main {
    public static void main(String[] args) {
        String[] options = {"HomeTank", "BuildingTank"};
        int choice = JOptionPane.showOptionDialog(null, "Select the tank type", "Water Tank",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        WaterTank tank;

        if (choice == 0) {
            tank = new HomeTank();
        } else {
            tank = new BuildingTank();
        }

        while (true) {
            tank.checkStatus();

            if (tank instanceof HomeTank && ((HomeTank) tank).currentWaterLevel == ((HomeTank) tank).capacity) {
                JOptionPane.showMessageDialog(null, "Tank is Full! Program ended.");
                break;
            }

            if (tank instanceof BuildingTank && ((BuildingTank) tank).currentWaterLevel == ((BuildingTank) tank).capacity) {
                JOptionPane.showMessageDialog(null, "Tank is Full! Program ended.");
                break;
            }

            String[] actions = {"Fill Water", "Use Water"};
            int actionChoice = JOptionPane.showOptionDialog(null, "What would you like to do?", "Water Tank",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, actions, actions[0]);

            int liters;
            if (actionChoice == 0) {
                liters = Integer.parseInt(JOptionPane.showInputDialog("Enter liters to fill:"));
                tank.fillTank(liters);
            } else if (actionChoice == 1) {
                liters = Integer.parseInt(JOptionPane.showInputDialog("Enter liters to use:"));
                tank.useWater(liters);
            }
            if (tank instanceof HomeTank && ((HomeTank) tank).currentWaterLevel == 0) {
                JOptionPane.showMessageDialog(null, "Tank is Empty! Program ended.");
                break;
            }

            if (tank instanceof BuildingTank && ((BuildingTank) tank).currentWaterLevel == 0) {
                JOptionPane.showMessageDialog(null, "Tank is Empty! Program ended.");
                break;
            }
        }
    }
}
