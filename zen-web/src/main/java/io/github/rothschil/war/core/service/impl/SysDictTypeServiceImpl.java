package io.github.rothschil.war.core.service.impl;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

import io.github.rothschil.war.constant.UserConstants;
import io.github.rothschil.war.core.domain.SysDictData;
import io.github.rothschil.war.core.domain.SysDictType;
import io.github.rothschil.war.core.mapper.SysDictDataMapper;
import io.github.rothschil.war.core.mapper.SysDictTypeMapper;
import io.github.rothschil.war.core.service.ISysDictTypeService;
import io.github.rothschil.war.util.DictUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import io.github.rothschil.common.exception.DrunkardException;
import io.github.rothschil.common.utils.StringUtils;
import io.github.rothschil.common.text.Convert;
import io.github.rothschil.common.core.domain.Ztree;

/**
 * 字典类型
 *
 * @author <a href="https://github.com/rothschil">Sam</a>
 * @date 2019/10/10 - 0:03
 * @since 1.0.0
 */
@Service
public class SysDictTypeServiceImpl implements ISysDictTypeService {
    @Autowired
    private SysDictTypeMapper dictTypeMapper;

    @Autowired
    private SysDictDataMapper dictDataMapper;

    /**
     * 项目启动时，初始化字典到缓存
     */
    @PostConstruct
    public void init() {
        List<SysDictType> dictTypeList = dictTypeMapper.selectDictTypeAll();
        for (SysDictType dictType : dictTypeList) {
            List<SysDictData> dictDatas = dictDataMapper.selectDictDataByType(dictType.getDictType());
            DictUtils.setDictCache(dictType.getDictType(), dictDatas);
        }
    }

    /**
     * 根据条件分页查询字典类型
     *
     * @param dictType 字典类型信息
     * @return 字典类型集合信息
     */
    @Override
    public List<SysDictType> selectDictTypeList(SysDictType dictType) {
        return dictTypeMapper.selectDictTypeList(dictType);
    }

    /**
     * 根据所有字典类型
     *
     * @return 字典类型集合信息
     */
    @Override
    public List<SysDictType> selectDictTypeAll() {
        return dictTypeMapper.selectDictTypeAll();
    }

    /**
     * 根据字典类型查询字典数据
     *
     * @param dictType 字典类型
     * @return 字典数据集合信息
     */
    @Override
    public List<SysDictData> selectDictDataByType(String dictType) {
        List<SysDictData> dictDatas = DictUtils.getDictCache(dictType);
        if (StringUtils.isNotEmpty(dictDatas)) {
            return dictDatas;
        }
        dictDatas = dictDataMapper.selectDictDataByType(dictType);
        if (StringUtils.isNotEmpty(dictDatas)) {
            DictUtils.setDictCache(dictType, dictDatas);
            return dictDatas;
        }
        return null;
    }

    /**
     * 根据字典类型ID查询信息
     *
     * @param dictId 字典类型ID
     * @return 字典类型
     */
    @Override
    public SysDictType selectDictTypeById(Long dictId) {
        return dictTypeMapper.selectDictTypeById(dictId);
    }

    /**
     * 根据字典类型查询信息
     *
     * @param dictType 字典类型
     * @return 字典类型
     */
    @Override
    public SysDictType selectDictTypeByType(String dictType) {
        return dictTypeMapper.selectDictTypeByType(dictType);
    }

    /**
     * 批量删除字典类型
     *
     * @param ids 需要删除的数据
     * @return 结果
     */
    @Override
    public int deleteDictTypeByIds(String ids) {
        Long[] dictIds = Convert.toLongArray(ids);
        for (Long dictId : dictIds) {
            SysDictType dictType = selectDictTypeById(dictId);
            if (dictDataMapper.countDictDataByType(dictType.getDictType()) > 0) {
                throw new DrunkardException(String.format("%1$s已分配,不能删除", dictType.getDictName()));
            }
        }
        int count = dictTypeMapper.deleteDictTypeByIds(dictIds);
        if (count > 0) {
            DictUtils.clearDictCache();
        }
        return count;
    }

    /**
     * 清空缓存数据
     */
    @Override
    public void clearCache() {
        DictUtils.clearDictCache();
    }

    /**
     * 新增保存字典类型信息
     *
     * @param dictType 字典类型信息
     * @return 结果
     */
    @Override
    public int insertDictType(SysDictType dictType) {
        int row = dictTypeMapper.insertDictType(dictType);
        if (row > 0) {
            DictUtils.clearDictCache();
        }
        return row;
    }

    /**
     * 修改保存字典类型信息
     *
     * @param dictType 字典类型信息
     * @return 结果
     */
    @Override
    @Transactional
    public int updateDictType(SysDictType dictType) {
        SysDictType oldDict = dictTypeMapper.selectDictTypeById(dictType.getId());
        dictDataMapper.updateDictDataType(oldDict.getDictType(), dictType.getDictType());
        int row = dictTypeMapper.updateDictType(dictType);
        if (row > 0) {
            DictUtils.clearDictCache();
        }
        return row;
    }

    /**
     * 校验字典类型称是否唯一
     *
     * @param dict 字典类型
     * @return 结果
     */
    @Override
    public String checkDictTypeUnique(SysDictType dict) {
        Long dictId = StringUtils.isNull(dict.getId()) ? -1L : dict.getId();
        SysDictType dictType = dictTypeMapper.checkDictTypeUnique(dict.getDictType());
        if (StringUtils.isNotNull(dictType) && dictType.getId().longValue() != dictId.longValue()) {
            return UserConstants.DICT_TYPE_NOT_UNIQUE;
        }
        return UserConstants.DICT_TYPE_UNIQUE;
    }

    /**
     * 查询字典类型树
     *
     * @param dictType 字典类型
     * @return 所有字典类型
     */
    @Override
    public List<Ztree> selectDictTree(SysDictType dictType) {
        List<Ztree> ztrees = new ArrayList<Ztree>();
        List<SysDictType> dictList = dictTypeMapper.selectDictTypeList(dictType);
        for (SysDictType dict : dictList) {
            if (UserConstants.DICT_NORMAL.equals(dict.getStatus())) {
                Ztree ztree = new Ztree();
                ztree.setId(dict.getId());
                ztree.setName(transDictName(dict));
                ztree.setTitle(dict.getDictType());
                ztrees.add(ztree);
            }
        }
        return ztrees;
    }

    public String transDictName(SysDictType dictType) {
        StringBuffer sb = new StringBuffer();
        sb.append("(" + dictType.getDictName() + ")");
        sb.append("&nbsp;&nbsp;&nbsp;" + dictType.getDictType());
        return sb.toString();
    }
}
