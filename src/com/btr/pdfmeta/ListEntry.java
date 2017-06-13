package com.btr.pdfmeta;

import java.io.File;

/*****************************************************************************
 * Small helper class to store files in the JList. 
 *
 * @author Bernd Rosstauscher (pdfmeta@rosstauscher.de) Copyright 2010
 ****************************************************************************/

class ListEntry {
	
	private String name;
	private String filePath;
	
	/*************************************************************************
	 * Constructor
	 * @param file
	 ************************************************************************/
	
	public ListEntry(String file) {
		super();
		
		this.filePath = file;
		this.name = this.filePath;
		int index = this.name.lastIndexOf(File.separatorChar);
		if (index > -1) {
			this.name = this.name.substring(index+1);
		}
		index = this.name.lastIndexOf('.');
		if (index > -1) {
			this.name = this.name.substring(0, index);
		}
	}

	/*************************************************************************
	 * toString
	 * @see java.lang.Object#toString()
	 ************************************************************************/
	@Override
	public String toString() {
		return name;
	}
	
	/*************************************************************************
	 * @return Returns the name.
	 ************************************************************************/
	
	public String getName() {
		return name;
	}

	/*************************************************************************
	 * @return Returns the filePath.
	 ************************************************************************/
	
	public String getFilePath() {
		return filePath;
	}

}