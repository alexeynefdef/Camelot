package org.anefdev.camelot.service;

import org.anefdev.camelot.exception.HarmonyNotFoundException;
import org.anefdev.camelot.model.Harmony;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@Service
public class HarmonyService {

    /**
     * Repository, witch contains 24 initialized enum entities representing harmonies
     */
    private final Map<String,Harmony> harmoniesRepo = Harmony.initHarmoniesMap();

    /**
     * @param id String "a[1-12]" or "b[1-12]"
     * @return Harmony object or throws exception if not found
     */
    public Harmony getByID(String id) {
        return Optional.of(harmoniesRepo.get(id)).orElseThrow(HarmonyNotFoundException::new);
    }

    /**
     *
     * @param id String "a[1-12]" or "b[1-12]"
     * @return a List of Harmony objects or throws exception if not found
     */
    public List<Harmony> getNeighboursByID(String id) {
        List<String> neighboursIDs = getByID(id).getHarmonieIDs();
        List<Harmony> neighboursResult = new ArrayList<>();
        for (String harmonyID:neighboursIDs) {
            neighboursResult.add(harmoniesRepo.get(harmonyID));
        }
        return neighboursResult;
    }
}
