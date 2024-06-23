from enum import Enum
from abc import ABC,abstractmethod
class LockerCategory(Enum):
    small = 1
    medium =2
    large = 3

class ItemCategory(Enum):
    small = 2
    medium =3
    large = 4
    
class Locker:
    count=0
    def __init__(self,rack,lockerType=LockerCategory.small) -> None:
        self.count+=1
        self.lockerNum =self.count
        self.lockerType = lockerType
        self.isOccupied=False
        self.item=None
        self.rack = rack
        
class Rack:
    
    def __createLockers(self,category,amount):
        for i in range(0,amount):
            self.lockers[category].append(Locker(self,category))
        self.available_lockers[category]=amount        


    def __init__(self,adress,small=0,medium=0,large =0 ) -> None:
        self.address = adress
        self.lockers = {LockerCategory.small:[],LockerCategory.medium:[],LockerCategory.large:[]}
        self.available_lockers = {LockerCategory.small:0,LockerCategory.medium:0,LockerCategory.large:0}
    
        self.__createLockers(LockerCategory.small,small)
        self.__createLockers(LockerCategory.medium,medium)
        self.__createLockers(LockerCategory.large,large)
        self.taken_lockers=set()

    def addLocker(self,locker):
        self.taken_lockers.remove(locker)
        self.lockers[locker.lockerType].append(locker)
        self.available_lockers[locker.lockerType]+=1
    

    
class Item:
    
    def __init__(self,name, itemCategory):
        self.name = name
        self.itemCategory = itemCategory
        self.isPlaced =False


class RackManagerService(ABC):


    @abstractmethod
    def placeItem():
        pass

    @abstractmethod
    def removeItem():
        pass


class RackManagerServiceImpl(RackManagerService):
    racks =[]
    def __init__(self):
        self.racks=[]

    def addRack(self,rack):
        self.racks.append(rack)
    

    def getAvailableRack(self,category):
        for rack in self.racks:
            if rack.available_lockers[category]>0:
                rack.available_lockers[category]-=1
                locker =rack.lockers[category].pop(0)
                rack.taken_lockers.add(locker)
                return locker
    
    def place(self,locker,item):
        locker.isOccupied=True
        locker.item =item
        
        print("Item has been placed in locker : "+str(locker.lockerNum)+ "at rack "+ locker.rack.address)
        return locker
        
    def placeItem(self,item):
        if item.itemCategory == ItemCategory.small:
            locker = self.getAvailableRack(LockerCategory.small)
            if locker:
                return self.place(locker,item)
                
            locker = self.getAvailableRack(LockerCategory.medium)
            if locker:
                return self.place(locker,item)
            locker = self.getAvailableRack(LockerCategory.large)
            if locker:
                return self.place(locker,item)
            print("Item cannot be placed sorry all lockers are full")
                
        elif item.itemCategory == ItemCategory.medium:
            locker = self.getAvailableRack(LockerCategory.medium)
            if locker:
                return self.place(locker,item)
            locker = self.getAvailableRack(LockerCategory.large)
            if locker:
                return self.place(locker,item)
            print("Item cannot be placed sorry all lockers are full")
        else:
            locker = self.getAvailableRack(LockerCategory.large)
            if locker:
                return self.place(locker,item)
            print("Item cannot be placed sorry all lockers are full")
    def removeItem(self,locker):
        if locker:
            if locker.item:
                locker.rack.addLocker(locker)
                return locker.item
            else:
                print("locker is empty")
                return None

    

if  __name__=='__main__':
    item1 = Item("phone",ItemCategory.small)
    item2 = Item("oven",ItemCategory.small)
    item3 = Item("scooter",ItemCategory.small)
    item4 = Item("fridge",ItemCategory.large)

    rack1 = Rack("whole foods",1,1,1)
    rack2 = Rack("cahill park",1,1,0)

    rackManagerServiceImpl =  RackManagerServiceImpl()
    rackManagerServiceImpl.addRack(rack1)
    rackManagerServiceImpl.addRack(rack2)

    rackManagerServiceImpl.placeItem(item1)
    rackManagerServiceImpl.placeItem(item2)
    locker = rackManagerServiceImpl.placeItem(item3)

    rackManagerServiceImpl.removeItem(locker)
    rackManagerServiceImpl.placeItem(item4)