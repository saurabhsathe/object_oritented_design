package Implementations.filterImplementations;

import Implementations.EntryImplementations.UnixFile;
import Interfaces.ParamFilter;

public class minSizeFilter implements ParamFilter {


        public Boolean isValid(Filters filters, UnixFile entry) {
            if(filters.minSize==Float.MAX_VALUE ){
                return true;
            }
            return entry.getSize()>=filters.minSize;
        }



}
