// command interface
interface Command {
    void execute();
}

//concrete command for turning on device on
class TurnOnCommand implements Command{
    private Device device;

    public TurnOnCommand(Device device){
        this.device = device;
    }

    @java.lang.Override
    public void execute() {
        device.turnOn();
    }
}
//Reciever Interface
interface Device {
    void turnOn();
    void turnOff();
}

//Concrete reviever for TV
class TV implements Device {
    @java.lang.Override
    public void turnOn() {
        System.out.println("TV is ON now");
    }

    @java.lang.Override
    public void turnOff() {
        System.out.println("TV is OFF now");
    }

    public void changeChannel() {
        System.out.println("TV is OFF now");
    }
}

//Invoker
class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}

public class CommandPatternExample 


