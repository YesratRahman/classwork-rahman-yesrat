#pragma checksum "/Users/yesratrahman/Desktop/TalentPath/classwork-rahman-yesrat/CourseManager/CourseManager/Views/Student/Details.cshtml" "{ff1816ec-aa5e-4d10-87f7-6f4963833460}" "d052aa9ab2d6f6cb27c850533c5794176e246319"
// <auto-generated/>
#pragma warning disable 1591
[assembly: global::Microsoft.AspNetCore.Razor.Hosting.RazorCompiledItemAttribute(typeof(AspNetCore.Views_Student_Details), @"mvc.1.0.view", @"/Views/Student/Details.cshtml")]
namespace AspNetCore
{
    #line hidden
    using System;
    using System.Collections.Generic;
    using System.Linq;
    using System.Threading.Tasks;
    using Microsoft.AspNetCore.Mvc;
    using Microsoft.AspNetCore.Mvc.Rendering;
    using Microsoft.AspNetCore.Mvc.ViewFeatures;
#nullable restore
#line 1 "/Users/yesratrahman/Desktop/TalentPath/classwork-rahman-yesrat/CourseManager/CourseManager/Views/_ViewImports.cshtml"
using CourseManager;

#line default
#line hidden
#nullable disable
#nullable restore
#line 2 "/Users/yesratrahman/Desktop/TalentPath/classwork-rahman-yesrat/CourseManager/CourseManager/Views/_ViewImports.cshtml"
using CourseManager.Models;

#line default
#line hidden
#nullable disable
    [global::Microsoft.AspNetCore.Razor.Hosting.RazorSourceChecksumAttribute(@"SHA1", @"d052aa9ab2d6f6cb27c850533c5794176e246319", @"/Views/Student/Details.cshtml")]
    [global::Microsoft.AspNetCore.Razor.Hosting.RazorSourceChecksumAttribute(@"SHA1", @"870e09f90f628899fb5293e1937c64ef3e3d7d37", @"/Views/_ViewImports.cshtml")]
    public class Views_Student_Details : global::Microsoft.AspNetCore.Mvc.Razor.RazorPage<Student>
    {
        #pragma warning disable 1998
        public async override global::System.Threading.Tasks.Task ExecuteAsync()
        {
            WriteLiteral("\n<h2>");
#nullable restore
#line 5 "/Users/yesratrahman/Desktop/TalentPath/classwork-rahman-yesrat/CourseManager/CourseManager/Views/Student/Details.cshtml"
Write(Model.Name);

#line default
#line hidden
#nullable disable
            WriteLiteral("</h2>\n<br />\n<hr />\n");
#nullable restore
#line 8 "/Users/yesratrahman/Desktop/TalentPath/classwork-rahman-yesrat/CourseManager/CourseManager/Views/Student/Details.cshtml"
 foreach (var c in Model.Courses)
{

#line default
#line hidden
#nullable disable
            WriteLiteral("    <h3>");
#nullable restore
#line 10 "/Users/yesratrahman/Desktop/TalentPath/classwork-rahman-yesrat/CourseManager/CourseManager/Views/Student/Details.cshtml"
   Write(c.Name);

#line default
#line hidden
#nullable disable
            WriteLiteral("</h3>\n    <br />\n");
#nullable restore
#line 12 "/Users/yesratrahman/Desktop/TalentPath/classwork-rahman-yesrat/CourseManager/CourseManager/Views/Student/Details.cshtml"
}

#line default
#line hidden
#nullable disable
        }
        #pragma warning restore 1998
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.ViewFeatures.IModelExpressionProvider ModelExpressionProvider { get; private set; }
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.IUrlHelper Url { get; private set; }
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.IViewComponentHelper Component { get; private set; }
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.Rendering.IJsonHelper Json { get; private set; }
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.Rendering.IHtmlHelper<Student> Html { get; private set; }
    }
}
#pragma warning restore 1591