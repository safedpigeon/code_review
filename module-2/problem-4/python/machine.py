from abc import ABC, abstractmethod

class IPrinter(ABC):
    @abstractmethod
    def print_doc(self, document: str):
        pass

class IScanner(ABC):
    @abstractmethod
    def scan_doc(self, document: str):
        pass

class IFax(ABC):
    @abstractmethod
    def fax_doc(self, document: str):
        pass
