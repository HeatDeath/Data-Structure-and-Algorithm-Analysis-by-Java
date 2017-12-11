package com.test.visitcontrol;

class People {  // 包访问权限（默认访问权限）

    private String name = null;

    public People(String name) {
        this.name = name;
    }

    String getName() {    //默认访问权限（包访问权限）
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }
}
