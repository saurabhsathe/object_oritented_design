from abc import ABC, abstractmethod


class ParkingLot:

    def __init__(self, levels, spots):
        self.levels = levels
        self.spots_levels = {}
        self.total_spots = spots
        self.available_slots_level = {}
        self.__buildParkingLot__()
        self.lotBuilder = SpotFactory()

    # builder design patter
    def __buildParkingLot__(self):
        slots_per_level = self.total_spots // self.levels
        extra_slots = self.total_spots % self.levels
        for i in range(1, self.levels + 1):
            self.spots_levels[i]["large"] = self.lotBuilder.getParkingSpots(slots_per_level // 2 + extra_slots, i,"large")
            extra_slots = max(extra_slots - 1, 0)
            self.spots_levels[i]["small"] = self.lotBuilder.getParkingSpots(slots_per_level // 2, i, "small")
            self.available_slots_level[i] = len(self.spots_levels[i]["small"]) + len(self.spots_levels[i]["medium"])
        print(self.spots_levels, self.available_slots_level)


class ParkingSpot(ABC):

    def __init__(self):
        self.isOccupied = False
        self.vehicle = None

    def isTaken(self):
        return self.isOccupied

    @abstractmethod
    def occupy(self, vehicle):
        pass

    def release(self):
        if not self.isOccupied:
            return False
        self.vehicle = None
        self.isOccupied = False
        return True


class SmallParkingSpot(ParkingSpot):

    def __init__(self, level):
        self.spotType = "compact"
        self.level = level
        self.vehicle_types = ["sedan"]

    def occupy(self, vehicle):
        if self.isOccupied or vehicle.type not in self.vehicle_types:
            return False
        self.isOccupied = True
        self.vehicle = vehicle
        return True


class LargeParkingSpot(ParkingSpot):

    def __init__(self, level):
        self.spotType = "large"
        self.level = level
        self.vehicle_types = ["sedan", "suv"]

    def occupy(self, vehicle):
        if self.isOccupied or vehicle.type not in self.vehicle_types:
            return False
        self.isOccupied = True
        self.vehicle = vehicle
        return True


class SpotFactory:

    def getParkingSpots(self, type, level, count):
        if type == "small":
            return [SmallParkingSpot(level) for _ in range(count)]
        else:
            return [LargeParkingSpot(level) for _ in range(count)]
