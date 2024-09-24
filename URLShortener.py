from enum import Enum
from abc import ABC, abstractmethod


class UrlShortenerMangerservice(ABC):

    @abstractmethod
    def getShortURL(self, orginalURL):
        pass

    @abstractmethod
    def getOriginalURL(self, shortURL):
        pass


class UrlShortenerMangerserviceImpl(UrlShortenerMangerservice):

    def __init__(self):
        self.urlInventory = {}

    def getShortURL(self, orginalURL):
        return "hello"

    def getOriginalURL(self, shortURL):
        return ""


if __name__ == '__main__':
    urlService = UrlShortenerMangerserviceImpl()
    shortened_url = urlService.getShortURL("hello")
