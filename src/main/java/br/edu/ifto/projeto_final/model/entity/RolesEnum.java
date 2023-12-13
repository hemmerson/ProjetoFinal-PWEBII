package br.edu.ifto.projeto_final.model.entity;

public enum RolesEnum {

    ROLE_ADMIN(1L),
    ROLE_USER(2L),
    ROLE_PACIENTE(3L),
    ROLE_MEDICO(4L);

    private final Long roleId;

    RolesEnum(Long roleId) {
        this.roleId = roleId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public static RolesEnum valueOf(int code){
        for (RolesEnum value : RolesEnum.values()){
            if (value.getRoleId() == code){
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid Role Code");
    }
}
