/*
 * Copyright 2024 Jack Meng (exoad). All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be
 * found in the LICENSE file.
 */
package pkg.exoad.omni.engine.env;

/**
 * Representation for Architecture information
 *
 * @author Jack Meng
 */
public enum ArchKey
{
    X86_32("x86_32",true),
    X86_64("x86_64",true),
    ARM("arm",true),
    ARM_64("arm64",true),
    PPC("ppc",false),
    IA64("ia64",false),
    SPARC("sparc",false),
    UNKNOWN("Unknown",false);
    final String properName;
    final boolean supported;

    ArchKey(String name,boolean supported)
    {
        this.properName=name;
        this.supported=supported;
    }

    public boolean isSupported()
    {
        return supported;
    }
    
    public String properName()
    {
        return properName;
    }
}
