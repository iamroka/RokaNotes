package com.roka.rokanotes.model.common;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Roka on 5/19/2017.
 */

public class NotesModel implements Parcelable {
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

    protected NotesModel(Parcel in) {
        noteTitle = in.readString();
        if (in.readByte() == 0x01) {
            notesMessage = new ArrayList<String>();
            in.readList(notesMessage, String.class.getClassLoader());
        } else {
            notesMessage = null;
        }
        isPinned = in.readByte() != 0x00;
        isChecked = in.readByte() != 0x00;
        notesCardColor = in.readInt();
        isSelected = in.readByte() != 0x00;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(noteTitle);
        if (notesMessage == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(notesMessage);
        }
        dest.writeByte((byte) (isPinned ? 0x01 : 0x00));
        dest.writeByte((byte) (isChecked ? 0x01 : 0x00));
        dest.writeInt(notesCardColor);
        dest.writeByte((byte) (isSelected ? 0x01 : 0x00));
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<NotesModel> CREATOR = new Parcelable.Creator<NotesModel>() {
        @Override
        public NotesModel createFromParcel(Parcel in) {
            return new NotesModel(in);
        }

        @Override
        public NotesModel[] newArray(int size) {
            return new NotesModel[size];
        }
    };

    public String getNoteTitle() {
        return noteTitle;
    }

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
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