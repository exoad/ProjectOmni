/*
 * Copyright 2024 Jack Meng (exoad). All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be
 * found in the LICENSE file.
 */
package pkg.exoad.omni.engine.env;

/**
 * Representation for Platform information
 *
 * @author Jack Meng
 */
public enum PlatformKey
{
    // Reference from OpenJDK repo:
    // WINDOWS: https://github.com/openjdk/jdk/blob/master/src/java.base/windows/native/libjava/java_props_md.c#L481-L568
    // UNIX: https://github.com/openjdk/jdk/blob/master/src/java.base/unix/native/libjava/java_props_md.c#L403
    // MACOS: https://github.com/openjdk/jdk/blob/master/src/java.base/macosx/native/libjava/java_props_macosx.c#L235
    WINDOWS_11("Windows 11",true),
    WINDOWS_10("Windows 10",true),
    WINDOWS_8_1("Windows 8.1",false), // no support
    WINDOWS_8("Windows 8",false), // no support
    WINDOWS_7("Windows 7",false),// no support
    WINDOWS_NT("Windows NT (unknown)",false), // no support
    WINDOWS_SERVER_2008("Windows Server 2008",false), // no support
    WINDOWS_SERVER_2008_R2("Windows Server 2008 R2",false), // no support
    WINDOWS_SERVER_2012("Windows Server 2012",false), // no support
    WINDOWS_SERVER_2012_R2("Windows Server 2012 R2",false), // no support
    WINDOWS_SERVER_2016("Windows Server 2016",true),
    WINDOWS_SERVER_2019("Windows Server 2019",true),
    WINDOWS_SERVER_2022("Windows Server 2022",true),
    WINDOWS_UNKNOWN("Windows (unknown)",false), // no support
    WINDOWS_VISTA("Windows Vista",false), // no support
    WINDOWS_XP("Windows XP",false), // no support
    WINDOWS_2003("Windows 2003",false), // no support
    WINDOWS_2000("Windows 2000",false), // no support
    UNIX(PlatformUtils.__unix_UNAME(),true), // returns whatever uname returns
    MACOS("Mac OS X",true),
    SOLARIS("Solaris",false), // no support
    UNKNOWN("Unknown",false);
    final String name;
    final boolean supported;

    PlatformKey(String name,boolean supported)
    {
        this.name=name;
        this.supported=supported;
    }

    public boolean isSupported()
    {
        return supported;
    }

    public String getName()
    {
        return name;
    }
}
