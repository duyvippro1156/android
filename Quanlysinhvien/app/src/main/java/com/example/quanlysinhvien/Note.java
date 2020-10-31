package com.example.quanlysinhvien;

import java.io.Serializable;

public class Note implements Serializable {

    private String noteId;
    private String noteName;
    private String notePhone;
    private String noteEmail;
    private String noteStreet;
    private String noteCity;

    public Note()  {
    }

    public Note(String noteId, String noteName, String notePhone, String noteEmail, String noteStreet, String noteCity) {
        this.noteId = noteId;
        this.noteName = noteName;
        this.notePhone = notePhone;
        this.noteEmail = noteEmail;
        this.noteStreet = noteStreet;
        this.noteCity = noteCity;
    }

    public String getNoteId() {
        return noteId;
    }

    public void setNoteId(String noteId) {
        this.noteId = noteId;
    }

    public String getNoteName() {
        return noteName;
    }

    public void setNoteName(String noteName) {
        this.noteName = noteName;
    }

    public String getNotePhone() {
        return notePhone;
    }

    public void setNotePhone(String notePhone) {
        this.notePhone = notePhone;
    }

    public String getNoteEmail() {
        return noteEmail;
    }

    public void setNoteEmail(String noteEmail) {
        this.noteEmail = noteEmail;
    }

    public String getNoteStreet() {
        return noteStreet;
    }

    public void setNoteStreet(String noteStreet) {
        this.noteStreet = noteStreet;
    }

    public String getNoteCity() {
        return noteCity;
    }

    public void setNoteCity(String noteCity) {
        this.noteCity = noteCity;
    }

    @Override
    public String toString()  {
        return this.noteName;
    }
}
