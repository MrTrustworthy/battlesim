package player.ability;

import player.ability.effect.Effect;
import player.ability.exceptions.AbilityException;
import player.unit.Unit;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class AbilityExecutor {
    private Unit origin;
    private String abilityName;
    private Ability ability;
    private Unit target;

    public AbilityExecutor(Unit origin, String abilityName, Unit target) {
        this.origin = origin;
        this.abilityName = abilityName;
        this.target = target;
    }

    public void executeAction() throws AbilityException {

        this.ability = origin.getAbilityByName(this.abilityName);

        this.validatePositions();

        List<Effect> effects = this.ability.getEffects();

        List<Effect> counterEffects = effects
                .stream()
                .map(effect -> effect.applyEffect(target))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        counterEffects.forEach(effect -> effect.applyEffect(origin));

    }

    private void validatePositions() throws AbilityException{
        if (!this.ability.canBeUsedFrom(this.origin.getPosition()) ||
                !this.ability.canBeUsedAgainst(this.target.getPosition())) {
            throw new AbilityException("This ability can't be used from or to this position");
        }
    }


}
