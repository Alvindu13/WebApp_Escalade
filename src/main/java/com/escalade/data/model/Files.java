package com.escalade.data.model;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "files")
public class Files {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "file_id")
    private int id;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "file_data")
    private byte[] data;

    @Column(name = "user_escalad_id")
    private Integer userEscaladId;

    @Column(name = "topo_id")
    private Integer topoId;

    public Files() {
    }

    public Files(String fileName, byte[] data, Integer userEscaladId, Integer topoId) {
        this.fileName = fileName;
        this.data = data;
        this.userEscaladId = userEscaladId;
        this.topoId = topoId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public Integer getUserEscaladId() {
        return userEscaladId;
    }

    public void setUserEscaladId(Integer userEscaladId) {
        this.userEscaladId = userEscaladId;
    }

    public Integer getTopoId() {
        return topoId;
    }

    public void setTopoId(Integer topoId) {
        this.topoId = topoId;
    }

    @Override
    public String toString() {
        return "Files{" +
                "id=" + id +
                ", fileName='" + fileName + '\'' +
                ", data=" + Arrays.toString(data) +
                ", userEscaladId=" + userEscaladId +
                ", topoId=" + topoId +
                '}';
    }
}
