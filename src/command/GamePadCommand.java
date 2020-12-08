package command;

import net.java.games.input.*;


public class GamePadCommand extends Command {
    public void gamePadInit(){
        Controller[] controllers = ControllerEnvironment.getDefaultEnvironment().getControllers();

        Controller gamepad = null;
        Controller stick = null;
        for (int i = 0; i < controllers.length; i++) {

            if (controllers[i].getType() == Controller.Type.KEYBOARD) {
                gamepad = controllers[i];
                System.out.println(gamepad);
            }

            if (controllers[i].getType() == Controller.Type.STICK) {
                stick = controllers[i];
                System.out.println(stick);
            }


            System.out.println(controllers[i]);
            System.out.println(controllers[i].getType());
        }

//        Component[] gamepadComponents = gamepad.getComponents();
//        Component[] stickComponents = stick.getComponents();
//
//        for (int i =0; i < gamepadComponents.length; i++){
//            System.out.println(gamepadComponents[i].getName());
//        }
////        for (int i =0; i < stickComponents.length; i++){
////            System.out.println(stickComponents[i].getName());
////        }

        EventQueue eventQueue = gamepad.getEventQueue();
        Event event = new Event();
        while (true) {
            gamepad.poll();
            eventQueue.getNextEvent(event);

            Component component = event.getComponent();

            if (component != null) {
                Component.Identifier identifier = component.getIdentifier();
                float data = component.getPollData();
                if (identifier == Component.Identifier.Key.A) {
                    System.out.println("0");
                    btn_0 = true;
                }

                if (identifier == Component.Identifier.Axis.X) {
                    if (data < 0)
                        System.out.println("down");
                    if (data > 0)
                        System.out.println("up");
                    if (data == 0)
                        System.out.println("null");
                }

            }
        }
    }

}
