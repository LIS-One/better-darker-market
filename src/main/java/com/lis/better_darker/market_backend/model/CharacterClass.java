package com.lis.better_darker.market_backend.model;

public enum CharacterClass {
    FIGHTER(1),
    BARBARIAN(1 << 2),
    ROGUE(1 << 3),
    RANGER(1 << 4),
    WIZARD(1 << 5),
    CLERIC(1 << 6),
    BARD(1 << 7),
    WARLOCK(1 << 8),
    DRUID(1 << 9),
    SORCERER(1 << 10)
    ;

    private final int mask;
    CharacterClass(int mask) {
        this.mask = mask;
    }
    public int getMask() {
        return mask;
    }
}
