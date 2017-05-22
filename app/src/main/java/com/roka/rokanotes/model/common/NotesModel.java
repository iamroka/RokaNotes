package com.roka.rokanotes.model.common;

import java.util.List;

/**
 * Created by Roka on 5/19/2017.
 */

public class NotesModel {
    private String noteTitle;
    private List<String> notesMessage;
    private boolean isPinned;
    private boolean isChecked;
    private int notesCardColor;
    private boolean isSelected;

    public NotesModel(String noteTitle, List<String> notesMessage, boolean isPinned, boolean isChecked, int notesCardColor) {
        this.noteTitle = noteTitle;
        this.notesMessage = notesMessage;
        this.isPinned = isPinned;
        this.isChecked = isChecked;
        this.notesCardColor = notesCardColor;
    }

    public NotesModel() {

    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public String getNoteTitle() {
        return noteTitle;
    }

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }

    public int getNotesCardColor() {
        return notesCardColor;
    }

    public void setNotesCardColor(int notesCardColor) {
        this.notesCardColor = notesCardColor;
    }

    public List<String> getNotesMessage() {
        return notesMessage;
    }

    public void setNotesMessage(List<String> notesMessage) {
        this.notesMessage = notesMessage;
    }

    public boolean isPinned() {
        return isPinned;
    }

    public void setPinned(boolean pinned) {
        isPinned = pinned;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}
