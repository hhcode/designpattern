package com.create.builder;

/**
 * 游戏角色创建控制器：指挥者
 *
 * @author hWX456381
 */
public class ActorController {
    /**
     * 逐步构建复杂产品对象
     *
     * @param ab
     * @return
     */
    public Actor construct(ActorBuilder ab) {
        Actor actor;
        ab.buildType();
        ab.buildSex();
        ab.buildFace();
        ab.buildCostume();
        ab.buildHairstyle();
        actor = ab.createActor();
        return actor;
    }
}