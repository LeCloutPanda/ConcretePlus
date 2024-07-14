import json
import os

# List of colors and types
colors = ["white", "orange", "magenta", "light_blue", "yellow", "lime", "pink", "gray", "light_gray", "cyan", "purple", "blue", "brown", "green", "red", "black"]
types = ["button", "carpet", "door_powered", "fence_gate", "fence", "pane", "pressure_plate", "slab", "stairs", "trapdoor_powered", "trapdoor", "door", "vertical_slab", "wall", "weighted_pressure_plate"]

template = {
    "type": "minecraft:stonecutting",
    "ingredient": {
        "item": "minecraft:<COLOR>_concrete"
    },
    "result": {
        "count": 1,
        "id": "pandamc_concreteplus:<COLOR>_concrete_<TYPE>"
    }
}

# Function to generate and save JSON objects
def generate_json_files(colors, types, directory):
    if not os.path.exists(directory):
        os.makedirs(directory)
    for color in colors:
        for type_ in types:
            json_object = json.loads(json.dumps(template).replace("<COLOR>", color).replace("<TYPE>", type_))
            filename = os.path.join(directory, f"{color}_concrete_{type_}_stonecutting.json")
            with open(filename, 'w') as file:
                json.dump(json_object, file, indent=4)
            print(f"File {filename} created.")

# Directory to save the JSON files
output_directory = "generated_files"

# Generate and save the JSON files
generate_json_files(colors, types, output_directory)