package combatcontroller;

import combatmap.Grid;
import player.unit.UnitGroup;

public class CombatController {


    private Grid gridPlayer, gridEnemy;
    UnitGroup playerGroup, enemyGroup;

    public CombatController(UnitGroup playerGroup, UnitGroup enemyGroup){

        this.playerGroup = playerGroup;
        this.enemyGroup = enemyGroup;
        this.gridPlayer = new Grid();
        this.gridEnemy = new Grid();

    }






}
