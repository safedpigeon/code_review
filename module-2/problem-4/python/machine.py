from abc import ABC, abstractmethod

class IMachine(ABC):
    @abstractmethod
    def print_doc(self, document: str):
        pass

    @abstractmethod
    def scan_doc(self, document: str):
        pass

    @abstractmethod
    def fax_doc(self, document: str):
        pass
