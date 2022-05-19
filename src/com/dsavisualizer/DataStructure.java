package com.dsavisualizer;

public interface DataStructure
{
    default String getName()
    {
        return this.getClass().getSimpleName();
    }
}
