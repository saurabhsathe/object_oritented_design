package Interfaces;

import Implementations.EntryImplementations.UnixFile;
import Implementations.filterImplementations.Filters;

public interface ParamFilter {

    Boolean isValid(Filters filters, UnixFile entry);

}
