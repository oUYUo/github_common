/*
1，GUI全称：Graphical User lnterface(图形用户接口)。用图形方式显示计算机操作界面。
2，CLI全称：Command line User lnterface(命令行用户接口)。用DOS命令行操作。
3，GUI提供的对象存在 java.Awt、javax.Swing 两个包中。
4，java.Awt：abstract Window ToolKit(抽象窗口工具包)，需调用本地系统方法实现功能。属重量级控件，移植性弱。
5，javax.Swing：在AWT基础上，建立一套图形界面系统，其中提供了更多组件，完全由java实现。增强了移植性，属轻量级控件。
6，java.awt.event包装的除了监听器就是事件。
7，继承关系图：
	Component：组件
	|---Container：容器，是一个特殊组件，该组件中可通过add方法添加其它组件进来。
	|	|---Window：窗口
	|	|	|---Frame：框架
	|	|	|---Dialog：对话框
	|	|		|---FileDialog：文件对话框
	|	|---Panel：面板
	|---Button：按钮
	|---Label：标签
	|---Checkbox：复选框
	|---TextComponent：文本组件
	|---TextArea：文本区（多行文本）
	|---TextField：文本框（单行文本）

---------------------------------------------- 布局管理器 -------------------------------------------------------

1，容器中的组件排放方式，就是布局。
2，常见布局管理器：LayoutManager 布局接口
	1，FlowLayout --- 流式布局管理器
	   居中，从左到有的顺序排列。例：1个组件位置在居中，2个组件位置排列居中。
	   Panel默认的布局管理器。

	2，BorderLayout --- 边界布局管理器
	   东，南，西，北，中
	   Frame默认的布局管理器
	
	3，GridLayout --- 网格布局管理器
	   规则的矩阵，如 win xp 计算器中的数字按钮。

	4，CardLayout --- 卡片布局管理器
	   选项卡，如易语言的选择夹

	5，GridBagLayout --- 网格包布局管理器
	   非规则的矩阵，如 win xp 计算器中 C、CE按钮

	6，Panel --- 面板布局管理器
	   如：易语言的分组框
*/