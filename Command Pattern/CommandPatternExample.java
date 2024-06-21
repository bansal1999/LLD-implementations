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

//concrete command for turning OFF device 
class TurnOffCommand implements Command {
    private Device device;

    public TurnOffCommand (Device device){
        this.device = device;
    }

    @Override
    public void execute(){
        device.turnOff();
    }
}


//Reciever Interface
interface Device {
    void turnOn();
    void turnOff();
}

//Concrete reciever for TV
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
        System.out.println("TV channel changed now");
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

public class CommandPatternExample{
    public static void main (String[] args) {
        TV tv = new TV();
        
        //create command objects
        Command turnOnTvCommand = new TurnOnCommand(tv);
        Command turnOffTvCommand = new TurnOffCommand(tv);
        
        //create remote control
        RemoteControl remote = new RemoteControl();

        //set and execute commands 
        remote.setCommand(turnOffTvCommand);
        remote.pressButton();

        remote.setCommand(turnOnTvCommand);
        remote.pressButton();


    }
}


