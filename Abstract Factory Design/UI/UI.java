import java.util.Scanner;

interface IButton {
    void press();
}

interface Itextbox {
    void setText();
}

class MacButton implements IButton {
    @Override
    public void press() {
        System.out.println("Mac button is pressed");
    }
}

class WinButton implements IButton {
    @Override
    public void press() {
        System.out.println("Windows Button is pressed");
    }
}

class MacTextBox implements Itextbox {
    @Override
    public void setText() {
        System.out.println("Mac text is set");
    }
}

class WinTextBox implements Itextbox {
    @Override
    public void setText() {
        System.out.println("Windows text is set");
    }
}

interface Ifactory {
    IButton createButton();

    Itextbox createTextbox();
}

class WinFactory implements Ifactory {
    @Override
    public IButton createButton() {
        return new WinButton();
    }

    @Override
    public Itextbox createTextbox() {
        return new WinTextBox();
    }
}

class MacFactory implements IFactory {
    @Override
    public IButton createButton() {
        return new MacButton();
    }

    @Override
    public Itextbox createTextbox() {
        return new MacTextBox();
    }
}

// Abstract factory
class GUIAbstractFactory {
    public static Ifactory createFactory(String osType) {
        if (osType.equals("windows")) {
            return new WinFactory();
        } else if (osType.equals("mac")) {
            return new MacFactory();
        }

        return null;
    }
}

public class UI {
    public static void main(String[] args) {
        System.out.println("Enter the machon OS");
        Scanner scanner = new Scanner(System.in);
        String osType = scanner.nextLine();
        scanner.close();

        Ifactory factory = GUIAbstractFactory.createFactory(osType);

        if (factory != null) {
            IButton button = factory.createButton();
            button.press();

            Itextbox textbox = factory.createTextbox();
            textbox.setText();
        } else {
            System.out.println("Invalid IS type");
        }

    }
}