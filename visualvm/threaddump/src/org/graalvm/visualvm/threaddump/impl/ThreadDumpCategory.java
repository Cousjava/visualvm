/*
 *  Copyright (c) 2007, 2011, Oracle and/or its affiliates. All rights reserved.
 *  DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 * 
 *  This code is free software; you can redistribute it and/or modify it
 *  under the terms of the GNU General Public License version 2 only, as
 *  published by the Free Software Foundation.  Oracle designates this
 *  particular file as subject to the "Classpath" exception as provided
 *  by Oracle in the LICENSE file that accompanied this code.
 * 
 *  This code is distributed in the hope that it will be useful, but WITHOUT
 *  ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 *  FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 *  version 2 for more details (a copy is included in the LICENSE file that
 *  accompanied this code).
 * 
 *  You should have received a copy of the GNU General Public License version
 *  2 along with this work; if not, write to the Free Software Foundation,
 *  Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 * 
 *  Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 *  or visit www.oracle.com if you need additional information or have any
 *  questions.
 */

package org.graalvm.visualvm.threaddump.impl;

import org.graalvm.visualvm.core.snapshot.SnapshotCategory;
import org.graalvm.visualvm.core.ui.DataSourceWindowManager;
import org.graalvm.visualvm.threaddump.ThreadDump;
import java.io.File;

/**
 *
 * @author Jiri Sedlacek
 */
public class ThreadDumpCategory extends SnapshotCategory<ThreadDump> {
    
    private static final String NAME = org.openide.util.NbBundle.getMessage(ThreadDumpCategory.class, "MSG_Thread_Dumps"); // NOI18N
    private static final String PREFIX = "threaddump";   // NOI18N
    private static final String SUFFIX = ".tdump";   // NOI18N
    
    public ThreadDumpCategory() {
        super(NAME, ThreadDump.class, PREFIX, SUFFIX, 10);
    }
    
    public boolean supportsOpenSnapshot() {
        return true;
    }
    
    public void openSnapshot(File file) {
        DataSourceWindowManager.sharedInstance().openDataSource(new ThreadDumpImpl(file, null)); // TODO: instance should be created by ThreadDumpProvider!
    }

}
