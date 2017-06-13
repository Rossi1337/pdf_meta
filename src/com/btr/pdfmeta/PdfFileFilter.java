package com.btr.pdfmeta;

import java.io.File;

import javax.swing.filechooser.FileFilter;

/*****************************************************************************
 * Filter for PDF files.
 *
 * @author Bernd Rosstauscher (pdfmeta@rosstauscher.de) Copyright 2010
 ****************************************************************************/

final class PdfFileFilter extends FileFilter implements java.io.FileFilter {
	
	/*************************************************************************
	 * Constructor
	 ************************************************************************/
	
	public PdfFileFilter() {
		super();
	}
	
	/*************************************************************************
	 * getDescription
	 * @see javax.swing.filechooser.FileFilter#getDescription()
	 ************************************************************************/
	@Override
	public String getDescription() {
		return Messages.getString("GuiEditor.filter"); //$NON-NLS-1$
	}

	/*************************************************************************
	 * accept
	 * @see javax.swing.filechooser.FileFilter#accept(java.io.File)
	 ************************************************************************/
	@Override
	public boolean accept(File f) {
		return f.isDirectory()
			|| f.getName().toLowerCase().endsWith(".pdf") ; //$NON-NLS-1$
	}
}
