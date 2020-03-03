package com.github.cloud.user.service;

import com.github.cloud.core.model.Tree;
import com.github.cloud.user.dto.SysMenuDTO;
import com.github.cloud.user.model.SysMenu;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <p>
 * 菜单权限表 服务类
 * </p>
 *
 * @since 2019-11-18
 */
public interface SysMenuService {

    List<Tree<SysMenu>> listMenuTree(Long uid);

    List<SysMenu> list(Map<String, Object> params);

    Tree<SysMenu> getTree();

    Tree<SysMenu> getTree(Long roleId);

    Set<String> listPerms(Long userId);

    /**
     * 保存菜单信息
     *
     * @param menu 菜单信息
     * @return 结果
     */
    boolean saveMenu(SysMenuDTO menu);

    boolean deleteMenu(Long menuId);
}
