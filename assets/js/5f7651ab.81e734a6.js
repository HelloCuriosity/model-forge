"use strict";(self.webpackChunkwebsite=self.webpackChunkwebsite||[]).push([[832],{3905:(e,t,r)=>{r.d(t,{Zo:()=>c,kt:()=>g});var n=r(7294);function o(e,t,r){return t in e?Object.defineProperty(e,t,{value:r,enumerable:!0,configurable:!0,writable:!0}):e[t]=r,e}function a(e,t){var r=Object.keys(e);if(Object.getOwnPropertySymbols){var n=Object.getOwnPropertySymbols(e);t&&(n=n.filter((function(t){return Object.getOwnPropertyDescriptor(e,t).enumerable}))),r.push.apply(r,n)}return r}function i(e){for(var t=1;t<arguments.length;t++){var r=null!=arguments[t]?arguments[t]:{};t%2?a(Object(r),!0).forEach((function(t){o(e,t,r[t])})):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(r)):a(Object(r)).forEach((function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(r,t))}))}return e}function l(e,t){if(null==e)return{};var r,n,o=function(e,t){if(null==e)return{};var r,n,o={},a=Object.keys(e);for(n=0;n<a.length;n++)r=a[n],t.indexOf(r)>=0||(o[r]=e[r]);return o}(e,t);if(Object.getOwnPropertySymbols){var a=Object.getOwnPropertySymbols(e);for(n=0;n<a.length;n++)r=a[n],t.indexOf(r)>=0||Object.prototype.propertyIsEnumerable.call(e,r)&&(o[r]=e[r])}return o}var d=n.createContext({}),s=function(e){var t=n.useContext(d),r=t;return e&&(r="function"==typeof e?e(t):i(i({},t),e)),r},c=function(e){var t=s(e.components);return n.createElement(d.Provider,{value:t},e.children)},p={inlineCode:"code",wrapper:function(e){var t=e.children;return n.createElement(n.Fragment,{},t)}},u=n.forwardRef((function(e,t){var r=e.components,o=e.mdxType,a=e.originalType,d=e.parentName,c=l(e,["components","mdxType","originalType","parentName"]),u=s(r),g=o,f=u["".concat(d,".").concat(g)]||u[g]||p[g]||a;return r?n.createElement(f,i(i({ref:t},c),{},{components:r})):n.createElement(f,i({ref:t},c))}));function g(e,t){var r=arguments,o=t&&t.mdxType;if("string"==typeof e||o){var a=r.length,i=new Array(a);i[0]=u;var l={};for(var d in t)hasOwnProperty.call(t,d)&&(l[d]=t[d]);l.originalType=e,l.mdxType="string"==typeof e?e:o,i[1]=l;for(var s=2;s<a;s++)i[s]=r[s];return n.createElement.apply(null,i)}return n.createElement.apply(null,r)}u.displayName="MDXCreateElement"},5082:(e,t,r)=>{r.r(t),r.d(t,{assets:()=>d,contentTitle:()=>i,default:()=>p,frontMatter:()=>a,metadata:()=>l,toc:()=>s});var n=r(7462),o=(r(7294),r(3905));const a={sidebar_position:1},i="Gradle Setup",l={unversionedId:"getting-started/gradle-dependency",id:"getting-started/gradle-dependency",title:"Gradle Setup",description:"Add the dependency to your build.gradle file to get started:",source:"@site/docs/getting-started/gradle-dependency.md",sourceDirName:"getting-started",slug:"/getting-started/gradle-dependency",permalink:"/model-forge/docs/getting-started/gradle-dependency",draft:!1,editUrl:"https://github.com/facebook/docusaurus/tree/main/packages/create-docusaurus/templates/shared/docs/getting-started/gradle-dependency.md",tags:[],version:"current",sidebarPosition:1,frontMatter:{sidebar_position:1},sidebar:"tutorialSidebar",previous:{title:"Getting Started",permalink:"/model-forge/docs/category/getting-started"},next:{title:"Generating Models",permalink:"/model-forge/docs/getting-started/generate-models"}},d={},s=[{value:"Feeling Adventurous \ud83d\udca5",id:"feeling-adventurous-",level:4}],c={toc:s};function p(e){let{components:t,...r}=e;return(0,o.kt)("wrapper",(0,n.Z)({},c,r,{components:t,mdxType:"MDXLayout"}),(0,o.kt)("h1",{id:"gradle-setup"},"Gradle Setup"),(0,o.kt)("p",null,"Add the dependency to your ",(0,o.kt)("inlineCode",{parentName:"p"},"build.gradle")," file to get started:"),(0,o.kt)("pre",null,(0,o.kt)("code",{parentName:"pre",className:"language-kotlin"},'dependencies {\n    testImplementation("io.github.hellocuriosity:model-forge:1.1.1")\n}\n')),(0,o.kt)("h4",{id:"feeling-adventurous-"},"Feeling Adventurous \ud83d\udca5"),(0,o.kt)("p",null,"If you're feeling adventurous you can be on the cutting edge and test a snapshot:"),(0,o.kt)("pre",null,(0,o.kt)("code",{parentName:"pre",className:"language-kotlin"},'repositories {\n    maven(url = "https://s01.oss.sonatype.org/content/repositories/snapshots/")\n}\n\ndependencies {\n    testImplementation("io.github.hellocuriosity:model-forge:1.1.1.xx-SNAPSHOT")\n}\n')))}p.isMDXComponent=!0}}]);