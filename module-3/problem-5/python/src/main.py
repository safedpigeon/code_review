from smart_home_controller import SmartHomeController
from devices import Light, Fan, AirConditioner
from commands import LightOnCommand, LightOffCommand, FanOnCommand, AcOnCommand

if __name__ == "__main__":
    controller = SmartHomeController()

    light = Light()
    fan = Fan()
    ac = AirConditioner()

    light_on = LightOnCommand(light)
    fan_on = FanOnCommand(fan)
    ac_on = AcOnCommand(ac)

    print("--- Executing Commands ---")
    controller.execute_command(light_on)
    controller.execute_command(fan_on)
    controller.execute_command(ac_on)

    print("\n--- Undoing Commands ---")
    controller.undo_command() # Undo AC On
    controller.undo_command() # Undo Fan On
    controller.undo_command() # Undo Light On

    print("\n--- Final check ---")
    controller.undo_command() # Should show "No commands to undo"
