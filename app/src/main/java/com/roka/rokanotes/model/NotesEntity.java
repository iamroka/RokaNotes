package com.roka.rokanotes.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Roka on 6/4/2017.
 */
@Entity(tableName = "notes_entity")
public class NotesEntity {
    @PrimaryKey
    private String notesId;
    @ColumnInfo(name = "notes_title")
    private String noteTitle;
    @ColumnInfo(name = "notes_message")
    private String notesMessage;
    @ColumnInfo(name = "is_pinned")
    private boolean isPinned;
    @ColumnInfo(name = "is_checked")
    private boolean isChecked;
    @ColumnInfo(name = "notes_card_color")
    private int notesCardColor;
    @Ignore
    private boolean isSelected;

    public String getNotesId() {
        return notesId;
    }

    public void setNotesId(String notesId) {
        this.notesId = notesId;
    }

    public String getNoteTitle() {
        return noteTitle;
    }

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }

    public String getNotesMessage() {
        return notesMessage;
    }

    public void setNotesMessage(String notesMessage) {
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

    public int getNotesCardColor() {
        return notesCardColor;
    }

    public void setNotesCardColor(int notesCardColor) {
        this.notesCardColor = notesCardColor;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
