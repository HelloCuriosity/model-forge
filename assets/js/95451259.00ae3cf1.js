"use strict";(self.webpackChunkwebsite=self.webpackChunkwebsite||[]).push([[251],{5366:(e,t,r)=>{r.r(t),r.d(t,{assets:()=>T,contentTitle:()=>V,default:()=>C,frontMatter:()=>N,metadata:()=>S,toc:()=>D});var n=r(4848),a=r(8453),l=r(6540),o=r(4164),s=r(3104),i=r(6347),u=r(205),c=r(7485),d=r(1682),m=r(679);function g(e){return l.Children.toArray(e).filter((e=>"\n"!==e)).map((e=>{if(!e||(0,l.isValidElement)(e)&&function(e){const{props:t}=e;return!!t&&"object"==typeof t&&"value"in t}(e))return e;throw new Error(`Docusaurus error: Bad <Tabs> child <${"string"==typeof e.type?e.type:e.type.name}>: all children of the <Tabs> component should be <TabItem>, and every <TabItem> should have a unique "value" prop.`)}))?.filter(Boolean)??[]}function p(e){const{values:t,children:r}=e;return(0,l.useMemo)((()=>{const e=t??function(e){return g(e).map((e=>{let{props:{value:t,label:r,attributes:n,default:a}}=e;return{value:t,label:r,attributes:n,default:a}}))}(r);return function(e){const t=(0,d.XI)(e,((e,t)=>e.value===t.value));if(t.length>0)throw new Error(`Docusaurus error: Duplicate values "${t.map((e=>e.value)).join(", ")}" found in <Tabs>. Every value needs to be unique.`)}(e),e}),[t,r])}function h(e){let{value:t,tabValues:r}=e;return r.some((e=>e.value===t))}function f(e){let{queryString:t=!1,groupId:r}=e;const n=(0,i.W6)(),a=function(e){let{queryString:t=!1,groupId:r}=e;if("string"==typeof t)return t;if(!1===t)return null;if(!0===t&&!r)throw new Error('Docusaurus error: The <Tabs> component groupId prop is required if queryString=true, because this value is used as the search param name. You can also provide an explicit value such as queryString="my-search-param".');return r??null}({queryString:t,groupId:r});return[(0,c.aZ)(a),(0,l.useCallback)((e=>{if(!a)return;const t=new URLSearchParams(n.location.search);t.set(a,e),n.replace({...n.location,search:t.toString()})}),[a,n])]}function b(e){const{defaultValue:t,queryString:r=!1,groupId:n}=e,a=p(e),[o,s]=(0,l.useState)((()=>function(e){let{defaultValue:t,tabValues:r}=e;if(0===r.length)throw new Error("Docusaurus error: the <Tabs> component requires at least one <TabItem> children component");if(t){if(!h({value:t,tabValues:r}))throw new Error(`Docusaurus error: The <Tabs> has a defaultValue "${t}" but none of its children has the corresponding value. Available values are: ${r.map((e=>e.value)).join(", ")}. If you intend to show no default tab, use defaultValue={null} instead.`);return t}const n=r.find((e=>e.default))??r[0];if(!n)throw new Error("Unexpected error: 0 tabValues");return n.value}({defaultValue:t,tabValues:a}))),[i,c]=f({queryString:r,groupId:n}),[d,g]=function(e){let{groupId:t}=e;const r=function(e){return e?`docusaurus.tab.${e}`:null}(t),[n,a]=(0,m.Dv)(r);return[n,(0,l.useCallback)((e=>{r&&a.set(e)}),[r,a])]}({groupId:n}),b=(()=>{const e=i??d;return h({value:e,tabValues:a})?e:null})();(0,u.A)((()=>{b&&s(b)}),[b]);return{selectedValue:o,selectValue:(0,l.useCallback)((e=>{if(!h({value:e,tabValues:a}))throw new Error(`Can't select invalid tab value=${e}`);s(e),c(e),g(e)}),[c,g,a]),tabValues:a}}var v=r(2303);const y={tabList:"tabList__CuJ",tabItem:"tabItem_LNqP"};function x(e){let{className:t,block:r,selectedValue:a,selectValue:l,tabValues:i}=e;const u=[],{blockElementScrollPositionUntilNextRender:c}=(0,s.a_)(),d=e=>{const t=e.currentTarget,r=u.indexOf(t),n=i[r].value;n!==a&&(c(t),l(n))},m=e=>{let t=null;switch(e.key){case"Enter":d(e);break;case"ArrowRight":{const r=u.indexOf(e.currentTarget)+1;t=u[r]??u[0];break}case"ArrowLeft":{const r=u.indexOf(e.currentTarget)-1;t=u[r]??u[u.length-1];break}}t?.focus()};return(0,n.jsx)("ul",{role:"tablist","aria-orientation":"horizontal",className:(0,o.A)("tabs",{"tabs--block":r},t),children:i.map((e=>{let{value:t,label:r,attributes:l}=e;return(0,n.jsx)("li",{role:"tab",tabIndex:a===t?0:-1,"aria-selected":a===t,ref:e=>u.push(e),onKeyDown:m,onClick:d,...l,className:(0,o.A)("tabs__item",y.tabItem,l?.className,{"tabs__item--active":a===t}),children:r??t},t)}))})}function j(e){let{lazy:t,children:r,selectedValue:a}=e;const s=(Array.isArray(r)?r:[r]).filter(Boolean);if(t){const e=s.find((e=>e.props.value===a));return e?(0,l.cloneElement)(e,{className:(0,o.A)("margin-top--md",e.props.className)}):null}return(0,n.jsx)("div",{className:"margin-top--md",children:s.map(((e,t)=>(0,l.cloneElement)(e,{key:t,hidden:e.props.value!==a})))})}function k(e){const t=b(e);return(0,n.jsxs)("div",{className:(0,o.A)("tabs-container",y.tabList),children:[(0,n.jsx)(x,{...t,...e}),(0,n.jsx)(j,{...t,...e})]})}function w(e){const t=(0,v.A)();return(0,n.jsx)(k,{...e,children:g(e.children)},String(t))}const I={tabItem:"tabItem_Ymn6"};function E(e){let{children:t,hidden:r,className:a}=e;return(0,n.jsx)("div",{role:"tabpanel",className:(0,o.A)(I.tabItem,a),hidden:r,children:t})}const N={sidebar_position:2},V="Generating Models",S={id:"getting-started/generate-models",title:"Generating Models",description:"Define your model",source:"@site/docs/getting-started/generate-models.md",sourceDirName:"getting-started",slug:"/getting-started/generate-models",permalink:"/model-forge/docs/getting-started/generate-models",draft:!1,unlisted:!1,editUrl:"https://github.com/facebook/docusaurus/tree/main/packages/create-docusaurus/templates/shared/docs/getting-started/generate-models.md",tags:[],version:"current",sidebarPosition:2,frontMatter:{sidebar_position:2},sidebar:"tutorialSidebar",previous:{title:"Gradle Setup",permalink:"/model-forge/docs/getting-started/gradle-dependency"},next:{title:"Custom Providers",permalink:"/model-forge/docs/getting-started/custom-providers"}},T={},D=[{value:"Define your model",id:"define-your-model",level:4},{value:"Generate",id:"generate",level:4},{value:"or by Delegation",id:"or-by-delegation",level:4}];function A(e){const t={code:"code",h1:"h1",h4:"h4",header:"header",pre:"pre",...(0,a.R)(),...e.components};return(0,n.jsxs)(n.Fragment,{children:[(0,n.jsx)(t.header,{children:(0,n.jsx)(t.h1,{id:"generating-models",children:"Generating Models"})}),"\n",(0,n.jsx)(t.h4,{id:"define-your-model",children:"Define your model"}),"\n",(0,n.jsx)(t.pre,{children:(0,n.jsx)(t.code,{className:"language-kotlin",children:"data class Employee(\n    val id: Long,\n    val name: String,\n    val dob: Instant,\n)\n"})}),"\n",(0,n.jsx)(t.h4,{id:"generate",children:"Generate"}),"\n",(0,n.jsxs)(w,{groupId:"generation",children:[(0,n.jsx)(E,{value:"model",label:"Model",default:!0,children:(0,n.jsx)(t.pre,{children:(0,n.jsx)(t.code,{className:"language-kotlin",children:"val forge = ModelForge()\nval employee = forge.build<Employee>()\n"})})}),(0,n.jsx)(E,{value:"list",label:"List",children:(0,n.jsx)(t.pre,{children:(0,n.jsx)(t.code,{className:"language-kotlin",children:"val forge = ModelForge()\nval employees = forge.buildList<Employee>(size = 3)\n"})})}),(0,n.jsx)(E,{value:"set",label:"Set",children:(0,n.jsx)(t.pre,{children:(0,n.jsx)(t.code,{className:"language-kotlin",children:"val forge = ModelForge()\nval employees = forge.buildSet<Employee>(size = 3)\n"})})})]}),"\n",(0,n.jsx)(t.h4,{id:"or-by-delegation",children:"or by Delegation"}),"\n",(0,n.jsxs)(w,{groupId:"generation",children:[(0,n.jsx)(E,{value:"model",label:"Model",default:!0,children:(0,n.jsx)(t.pre,{children:(0,n.jsx)(t.code,{className:"language-kotlin",children:"val employee: Employee by forgery()\n"})})}),(0,n.jsx)(E,{value:"list",label:"List",children:(0,n.jsx)(t.pre,{children:(0,n.jsx)(t.code,{className:"language-kotlin",children:"val employees: List<Employee> by forgeryList(size = 3)\n"})})}),(0,n.jsx)(E,{value:"set",label:"Set",children:(0,n.jsx)(t.pre,{children:(0,n.jsx)(t.code,{className:"language-kotlin",children:"val employees: List<Employee> by forgerySet(size = 3)\n"})})})]})]})}function C(e={}){const{wrapper:t}={...(0,a.R)(),...e.components};return t?(0,n.jsx)(t,{...e,children:(0,n.jsx)(A,{...e})}):A(e)}},8453:(e,t,r)=>{r.d(t,{R:()=>o,x:()=>s});var n=r(6540);const a={},l=n.createContext(a);function o(e){const t=n.useContext(l);return n.useMemo((function(){return"function"==typeof e?e(t):{...t,...e}}),[t,e])}function s(e){let t;return t=e.disableParentContext?"function"==typeof e.components?e.components(a):e.components||a:o(e.components),n.createElement(l.Provider,{value:t},e.children)}}}]);