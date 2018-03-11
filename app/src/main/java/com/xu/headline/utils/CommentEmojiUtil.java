package com.xu.headline.utils;

import android.text.SpannableString;

import com.xu.headline.R;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/3/10.
 *
 * @author xu
 *         处理含有表情的评论
 *         https://www.cnblogs.com/lichenwei/p/4676214.html
 */

public class CommentEmojiUtil {
    public static Map<String, Integer> emojiMap;

    public static SpannableString getEmojiString(String commentString) {
        SpannableString spannableString = new SpannableString(commentString);


        return spannableString;
    }

    static {
        emojiMap = new HashMap<String, Integer>();
        //第一页
        emojiMap.put("[捂脸]", R.mipmap.emoji1_1_1);
        emojiMap.put("[大笑]", R.mipmap.emoji1_1_2);
        emojiMap.put("[呲牙]", R.mipmap.emoji1_1_3);
        emojiMap.put("[爱慕]", R.mipmap.emoji1_1_4);
        emojiMap.put("[流泪]", R.mipmap.emoji1_1_5);
        emojiMap.put("[害羞]", R.mipmap.emoji1_1_6);
        emojiMap.put("[灵光一闪]", R.mipmap.emoji1_1_7);

        emojiMap.put("[发怒]", R.mipmap.emoji1_2_1);
        emojiMap.put("[抠鼻]", R.mipmap.emoji1_2_2);
        emojiMap.put("[酷拽]", R.mipmap.emoji1_2_3);
        emojiMap.put("[耶]", R.mipmap.emoji1_2_4);
        emojiMap.put("[可爱]", R.mipmap.emoji1_2_5);
        emojiMap.put("[机智]", R.mipmap.emoji1_2_6);
        emojiMap.put("[打脸]", R.mipmap.emoji1_2_7);

        emojiMap.put("[笑哭]", R.mipmap.emoji1_3_1);
        emojiMap.put("[我想静静]", R.mipmap.emoji1_3_2);
        emojiMap.put("[泪奔]", R.mipmap.emoji1_3_3);
        emojiMap.put("[赞]", R.mipmap.emoji1_3_4);
        emojiMap.put("[谢谢]", R.mipmap.emoji1_3_5);
        emojiMap.put("[玫瑰]", R.mipmap.emoji1_3_6);

        //第二页
        emojiMap.put("[微笑]", R.mipmap.emoji2_1_1);
        emojiMap.put("[哈欠]", R.mipmap.emoji2_1_2);
        emojiMap.put("[震惊]", R.mipmap.emoji2_1_3);
        emojiMap.put("[送心]", R.mipmap.emoji2_1_4);
        emojiMap.put("[困]", R.mipmap.emoji2_1_5);
        emojiMap.put("[what]", R.mipmap.emoji2_1_6);
        emojiMap.put("[泣不成声]", R.mipmap.emoji2_1_7);

        emojiMap.put("[小鼓掌]", R.mipmap.emoji2_2_1);
        emojiMap.put("[大金牙]", R.mipmap.emoji2_2_2);
        emojiMap.put("[偷笑]", R.mipmap.emoji2_2_3);
        emojiMap.put("[石化]", R.mipmap.emoji2_2_4);
        emojiMap.put("[思考]", R.mipmap.emoji2_2_5);
        emojiMap.put("[吐血]", R.mipmap.emoji2_2_6);
        emojiMap.put("[可怜]", R.mipmap.emoji2_2_7);

        emojiMap.put("[嘘]", R.mipmap.emoji2_3_1);
        emojiMap.put("[撇嘴]", R.mipmap.emoji2_3_2);
        emojiMap.put("[黑线]", R.mipmap.emoji2_3_3);
        emojiMap.put("[鼾睡]", R.mipmap.emoji2_3_4);
        emojiMap.put("[雾霾]", R.mipmap.emoji2_3_5);
        emojiMap.put("[奸笑]", R.mipmap.emoji2_3_6);


        //第三页
        emojiMap.put("[得意]", R.mipmap.emoji3_1_1);
        emojiMap.put("[憨笑]", R.mipmap.emoji3_1_2);
        emojiMap.put("[抓狂]", R.mipmap.emoji3_1_3);
        emojiMap.put("[惊呆]", R.mipmap.emoji3_1_4);
        emojiMap.put("[钱]", R.mipmap.emoji3_1_5);
        emojiMap.put("[kiss]", R.mipmap.emoji3_1_6);
        emojiMap.put("[恐惧]", R.mipmap.emoji3_1_7);

        emojiMap.put("[笑]", R.mipmap.emoji3_2_1);
        emojiMap.put("[快哭了]", R.mipmap.emoji3_2_2);
        emojiMap.put("[翻白眼]", R.mipmap.emoji3_2_3);
        emojiMap.put("[互粉]", R.mipmap.emoji3_2_4);
        emojiMap.put("[皱眉]", R.mipmap.emoji3_2_5);
        emojiMap.put("[擦汗]", R.mipmap.emoji3_2_6);
        emojiMap.put("[红脸]", R.mipmap.emoji3_2_7);

        emojiMap.put("[做鬼脸]", R.mipmap.emoji3_3_1);
        emojiMap.put("[尬笑]", R.mipmap.emoji3_3_2);
        emojiMap.put("[汗]", R.mipmap.emoji3_3_3);
        emojiMap.put("[吐]", R.mipmap.emoji3_3_4);
        emojiMap.put("[惊喜]", R.mipmap.emoji3_3_5);
        emojiMap.put("[摸头]", R.mipmap.emoji3_3_6);

        //第四页
        emojiMap.put("[来看我]", R.mipmap.emoji4_1_1);
        emojiMap.put("[委屈]", R.mipmap.emoji4_1_2);
        emojiMap.put("[舔屏]", R.mipmap.emoji4_1_3);
        emojiMap.put("[鄙视]", R.mipmap.emoji4_1_4);
        emojiMap.put("[飞吻]", R.mipmap.emoji4_1_5);
        emojiMap.put("[紫薇别走]", R.mipmap.emoji4_1_6);
        emojiMap.put("[吐彩虹]", R.mipmap.emoji4_1_7);

        emojiMap.put("[听歌]", R.mipmap.emoji4_2_1);
        emojiMap.put("[求抱抱]", R.mipmap.emoji4_2_2);
        emojiMap.put("[周冬雨的凝视]", R.mipmap.emoji4_2_3);
        emojiMap.put("[马思纯的微笑]", R.mipmap.emoji4_2_4);
        emojiMap.put("[敲打]", R.mipmap.emoji4_2_5);
        emojiMap.put("[绿帽子]", R.mipmap.emoji4_2_6);
        emojiMap.put("[再见]", R.mipmap.emoji4_2_7);

        emojiMap.put("[吃瓜群众]", R.mipmap.emoji4_3_1);
        emojiMap.put("[强]", R.mipmap.emoji4_3_2);
        emojiMap.put("[如花]", R.mipmap.emoji4_3_3);
        emojiMap.put("[奋斗]", R.mipmap.emoji4_3_4);
        emojiMap.put("[衰]", R.mipmap.emoji4_3_5);
        emojiMap.put("[闭嘴]", R.mipmap.emoji4_3_6);

        //第五页
        emojiMap.put("[晕]", R.mipmap.emoji5_1_1);
        emojiMap.put("[大哭]", R.mipmap.emoji5_1_2);
        emojiMap.put("[左上]", R.mipmap.emoji5_1_3);
        emojiMap.put("[小鼓掌]", R.mipmap.emoji5_1_4);
        emojiMap.put("[握手]", R.mipmap.emoji5_1_5);
        emojiMap.put("[比心]", R.mipmap.emoji5_1_6);
        emojiMap.put("[加油]", R.mipmap.emoji5_1_7);

        emojiMap.put("[碰拳]", R.mipmap.emoji5_2_1);
        emojiMap.put("[ok]", R.mipmap.emoji5_2_2);
        emojiMap.put("[击掌]", R.mipmap.emoji5_2_3);
        emojiMap.put("[kiss]", R.mipmap.emoji5_2_4);
        emojiMap.put("[去污粉]", R.mipmap.emoji5_2_5);
        emojiMap.put("[666]", R.mipmap.emoji5_2_6);
        emojiMap.put("[胡瓜]", R.mipmap.emoji5_2_7);

        emojiMap.put("[撒花]", R.mipmap.emoji5_3_1);
        emojiMap.put("[啤酒]", R.mipmap.emoji5_3_2);
        emojiMap.put("[送心]", R.mipmap.emoji5_3_3);
        emojiMap.put("[伤心]", R.mipmap.emoji5_3_4);
        emojiMap.put("[屎]", R.mipmap.emoji5_3_5);
        emojiMap.put("[18禁]", R.mipmap.emoji5_3_6);

        //第六页
        emojiMap.put("[吐舌]", R.mipmap.emoji6_1_1);
        emojiMap.put("[呆无辜]", R.mipmap.emoji6_1_2);
        emojiMap.put("[看]", R.mipmap.emoji6_1_3);
        emojiMap.put("[白眼]", R.mipmap.emoji6_1_4);
        emojiMap.put("[熊吉]", R.mipmap.emoji6_1_5);
        emojiMap.put("[不看]", R.mipmap.emoji6_1_6);
        emojiMap.put("[黑脸]", R.mipmap.emoji6_1_7);

        emojiMap.put("[骷髅]", R.mipmap.emoji6_2_1);
        emojiMap.put("[炸弹]", R.mipmap.emoji6_2_2);
        emojiMap.put("[蛋糕]", R.mipmap.emoji6_2_3);
        emojiMap.put("[礼物]", R.mipmap.emoji6_2_4);
        emojiMap.put("[刀]", R.mipmap.emoji6_2_5);
        emojiMap.put("[V5]", R.mipmap.emoji6_2_6);
        emojiMap.put("[给力]", R.mipmap.emoji6_2_7);
    }

}
