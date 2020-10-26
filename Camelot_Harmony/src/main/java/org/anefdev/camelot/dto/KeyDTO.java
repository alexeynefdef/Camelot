package org.anefdev.camelot.dto;

import org.anefdev.camelot.model.Harmony;

import java.util.List;

public class KeyDTO {

    private String id;
    private List<String> neighbours;
    private String keyNote;
    private String semitone;
    private String fret;

    public KeyDTO() {
    }

    /**
     * Constructor, witch transforms a Harmony object into KeyDTO object
     * @param harmony Harmony object
     */
    public KeyDTO(Harmony harmony) {
        String[] splitKey = splitKey(harmony.getKey());
        this.id = harmony.getId();
        this.keyNote = splitKey[0];
        this.semitone = splitKey[1];
        this.fret = splitKey[3];
        this.neighbours = harmony.getHarmonieIDs();
    }

    private String[] splitKey(String rawKey) {
        return rawKey.split("-");
    }
}
