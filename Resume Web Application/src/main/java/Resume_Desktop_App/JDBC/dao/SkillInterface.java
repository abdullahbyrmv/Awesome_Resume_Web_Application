package Resume_Desktop_App.JDBC.dao;

import Resume_Desktop_App.JDBC.entity.Skill;

import java.util.List;

public interface SkillInterface {
    public List<Skill> getSkillByID(int user_id);

    public List<Skill> getAllSkills();

    public boolean insertSkill(Skill skill);
}
