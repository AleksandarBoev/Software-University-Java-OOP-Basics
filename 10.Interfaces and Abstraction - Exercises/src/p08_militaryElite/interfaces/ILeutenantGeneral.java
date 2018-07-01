package p08_militaryElite.interfaces;

import p08_militaryElite.classes.Private;

import java.util.Set;

public interface ILeutenantGeneral extends IPrivate {
    Set<Private> getPrivates();
}
