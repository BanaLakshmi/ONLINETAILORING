package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DressKindMaster")
public class DressKind {
	@Id
	private int kindId;
	private String kind;
public DressKind(int kindId, String kind) {
		super();
		this.kindId = kindId;
		this.kind = kind;
	}

public int getKindId() {
	return kindId;
}
public void setKindId(int kindId) {
	this.kindId = kindId;
}
@Override
public String toString() {
	return "DressKind [kindId=" + kindId + ", kind=" + kind + "]";
}

public String getKind() {
	return kind;
}
public void setKind(String kind) {
	this.kind = kind;
}

}
