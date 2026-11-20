from smart_home_controller import SmartHomeController

if __name__ == "__main__":
    controller = SmartHomeController()

    controller.execute_action("Light", "ON")
    controller.execute_action("Fan", "ON")
    controller.execute_action("AirConditioner", "OFF")
    controller.execute_action("Television", "ON") # Should fail

    print(f"Final Light State: {controller.get_state('Light')}")
