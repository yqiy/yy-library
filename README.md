# yy-library
> epsoft-view为公司控件，暂不做公用库，请自行拷到项目修改。    
> 主应用中主题请继承YYTheme
> 配置DESIGN_WIDTH设计尺寸供ScreenInfo使用
> library使用到的库请看install.gradle文件
### Step 1. Add it in your root build.gradle at the end of repositories:
		allprojects {
				repositories {
					...
					maven { url 'https://jitpack.io' }
				}
			}
### Step 2. Add the dependency
		dependencies {
			        compile 'com.github.yqiy:yy-library:0.2.8'
			}