package com.application.areca.launcher.gui;

import com.application.areca.impl.policy.FTPFileSystemPolicy;
import com.application.areca.impl.policy.FileSystemPolicy;
import com.application.areca.plugins.StorageSelectionHelper;

/**
 * <BR>
 * @author Olivier PETRUCCI
 * <BR>
 *
 */

 /*
 Copyright 2005-2014, Olivier PETRUCCI.

This file is part of Areca.

    Areca is free software; you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation; either version 2 of the License, or
    (at your option) any later version.

    Areca is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Areca; if not, write to the Free Software
    Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA

 */
public class FTPStorageSelectionHelper implements StorageSelectionHelper {

    private TargetEditionWindow window;
    
    public FileSystemPolicy handleConfiguration() {
        return showFTPEditionFrame((FTPFileSystemPolicy)window.currentPolicy);
    }

    public void handleSelection() {
        window.rdZip.setSelection(true);
        window.rdDir.setSelection(false);
        window.rdZip64.setSelection(false);
    }

    public void setWindow(TargetEditionWindow window) {
        this.window = window; 
    }
    
    private FTPFileSystemPolicy showFTPEditionFrame(FTPFileSystemPolicy policy) {
        FTPEditionWindow frm = new FTPEditionWindow(policy);
        frm.setModal(window);
        frm.setBlockOnOpen(true);
        frm.open();
        
        FTPFileSystemPolicy ft = frm.getCurrentPolicy();
        if (ft != null) {
            ft.setId("ftp");
        }
        return ft;
    }
}
