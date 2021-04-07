package com.videos.domain;

public class Tag {
	  protected StringBuilder fraseTag = new StringBuilder(120);

	  
	 public Tag(StringBuilder fraseTag) throws Exception{
		 if(fraseTag==null)
			 throw new Exception();
		 this.fraseTag=fraseTag;
	 }


	public StringBuilder getFraseTag() {
		return fraseTag;
	}


	public void setFraseTag(StringBuilder fraseTag) {
		this.fraseTag = fraseTag.append(fraseTag);
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((fraseTag == null) ? 0 : fraseTag.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tag other = (Tag) obj;
		if (fraseTag == null) {
			if (other.fraseTag != null)
				return false;
		} else if (!fraseTag.equals(other.fraseTag))
			return false;
		return true;
	}
	  
	  
	  
}
