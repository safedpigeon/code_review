class SmartHomeController:
    def __init__(self):
        self.device_states = {}

    def execute_action(self, device, action):
        print(f"Executing {action} on {device}")
        
        device = device.lower()
        action = action.upper()

        if device == "light":
            if action == "ON":
                self.device_states["light"] = "ON"
                print("Light is now ON")
            elif action == "OFF":
                self.device_states["light"] = "OFF"
                print("Light is now OFF")
            else:
                print("Unknown action for Light")
        elif device == "fan":
            if action == "ON":
                self.device_states["fan"] = "ON"
                print("Fan is now ON")
            elif action == "OFF":
                self.device_states["fan"] = "OFF"
                print("Fan is now OFF")
            else:
                print("Unknown action for Fan")
        elif device == "airconditioner":
            if action == "ON":
                self.device_states["airconditioner"] = "ON"
                print("AC is now ON")
            elif action == "OFF":
                self.device_states["airconditioner"] = "OFF"
                print("AC is now OFF")
            else:
                print("Unknown action for AC")
        else:
            print(f"Device not found: {device}")

    def get_state(self, device):
        return self.device_states.get(device.lower(), "UNKNOWN")
