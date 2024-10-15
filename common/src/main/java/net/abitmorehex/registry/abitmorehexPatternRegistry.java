package net.abitmorehex.registry;

import at.petrak.hexcasting.api.PatternRegistry;
import at.petrak.hexcasting.api.spell.Action;
import at.petrak.hexcasting.api.spell.math.HexDir;
import at.petrak.hexcasting.api.spell.math.HexPattern;
import kotlin.Triple;
import net.abitmorehex.casting.patterns.math.OpRemoveEveryNth;
import net.abitmorehex.casting.patterns.math.OpReplaceEveryNth;
import net.abitmorehex.casting.patterns.math.OpBlockRaycastWithBacktrack;
import net.abitmorehex.casting.patterns.spells.OpCongrats;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

import static net.abitmorehex.abitmorehex.id;

public class abitmorehexPatternRegistry {
    public static List<Triple<HexPattern, Identifier, Action>> PATTERNS = new ArrayList<>();
    public static List<Triple<HexPattern, Identifier, Action>> PER_WORLD_PATTERNS = new ArrayList<>();
    // IMPORTANT: be careful to keep the registration calls looking like this or be prepared to edit the regex pattern on line 199 of the docgen script (doc/collate_data.py)
    public static HexPattern CONGRATS = registerPerWorld(HexPattern.fromAngles("eed", HexDir.WEST), "congrats", new OpCongrats());
    public static HexPattern THOUGHTCLEAR = register(HexPattern.fromAngles("adadadeaqqq", HexDir.NORTH_WEST), "thoughtclear", new OpRemoveEveryNth());
    public static HexPattern THOUGHTCLUTTER = register(HexPattern.fromAngles("dadadawedqdew", HexDir.NORTH_EAST), "thoughtclutter", new OpReplaceEveryNth());
    public static HexPattern UNVEILEDSIGHTS = register(HexPattern.fromAngles("wdaqqqaqeqaeaqa", HexDir.EAST), "unveiledsights", new OpBlockRaycastWithBacktrack());
//Also important for me, these errors about the actions can be ignored.

    public static void init() {
        try {
            for (Triple<HexPattern, Identifier, Action> patternTriple : PATTERNS) {
                PatternRegistry.mapPattern(patternTriple.getFirst(), patternTriple.getSecond(), patternTriple.getThird());
            }
            for (Triple<HexPattern, Identifier, Action> patternTriple : PER_WORLD_PATTERNS) {
                PatternRegistry.mapPattern(patternTriple.getFirst(), patternTriple.getSecond(), patternTriple.getThird(), true);
            }
        } catch (PatternRegistry.RegisterPatternException e) {
            e.printStackTrace();
        }
    }

    private static HexPattern register(HexPattern pattern, String name, Action action) {
        Triple<HexPattern, Identifier, Action> triple = new Triple<>(pattern, id(name), action);
        PATTERNS.add(triple);
        return pattern;
    }

    private static HexPattern registerPerWorld(HexPattern pattern, String name, Action action) {
        Triple<HexPattern, Identifier, Action> triple = new Triple<>(pattern, id(name), action);
        PER_WORLD_PATTERNS.add(triple);
        return pattern;
    }
}
